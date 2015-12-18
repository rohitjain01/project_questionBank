$(document).ready(
		function() {
			$('ul.nav.navbar-nav').find('a[href="' + location.pathname + '"]')
					.closest('li').addClass('active');
			
			
		});
function check() {
	var pwd = document.getElementById('passwordf').value;
	var re_pwd = document.getElementById('confirmPassword').value;
	var len = document.getElementById('passwordf').value.length;

	document.getElementById("strength").style.color = "red";
	var strength = document.getElementById("strength");

	if (pwd != re_pwd) {
		document.getElementById('confirmPassword').focus();
		document.getElementById('passwordf').focus();
		strength.innerHTML = "Password doesn't match";
		return false;

	} else if (len < 8) {
		document.getElementById('passwordf').focus();
		strength.innerHTML = "Password length is less than 8";
		return false;
	}

	return true;
}


function passwordStrength(password)
{
	var desc = new Array();
	desc[0] = "Very Weak";
	desc[1] = "Weak";
	desc[2] = "Better";
	desc[3] = "Medium";
	desc[4] = "Strong";
	desc[5] = "Strongest";

	var score   = 0;

	//if password bigger than 6 give 1 point
	if (password.length > 6) score++;

	//if password has both lower and uppercase characters give 1 point	
	if ( ( password.match(/[a-z]/) ) && ( password.match(/[A-Z]/) ) ) score++;

	//if password has at least one number give 1 point
	if (password.match(/\d+/)) score++;

	//if password has at least one special caracther give 1 point
	if ( password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/) )	score++;

	//if password bigger than 12 give another 1 point
	if (password.length > 12) score++;

	 document.getElementById("passwordDescription").innerHTML = desc[score];
	 document.getElementById("passwordStrength").className = "strength" + score;
}