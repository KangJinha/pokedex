const passwordCheck = document.getElementById("userPwCheck");
	passwordCheck.addEventListener("keyup",e=>{
	const pw = document.getElementById("userPw").value;
	const pwck = e.target.value;
	let msg,color,result;
	const $result = document.getElementById("result");
	const $submit = document.querySelector("input[type=submit]");
	if(pwck.length>=5){
		if(pw==pwck){
			msg="일치합니다 :)";
			color="skyblue";
			result = false;
		} else {
			msg="일치하지 않습니다 :(";
			color="pink";
			result = true;
		}
		$result.innerText = msg;
		$result.style.color = color;
		$submit.disabled = result;
	} else {
		$result.innerText = "5글자이상 입력";
		$submit.disabled = true;
	}
	
	
	
	
})