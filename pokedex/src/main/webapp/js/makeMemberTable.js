function makeMemberTable(members){
	const $table = $("<table>");
		const $header = $("<tr>");
		$header.html("<th>아이디</th>"
		+"<th>닉네임</th><th>나이</th><th>이메일</th>"
		+"<th>전화번호</th><th>등록일</th>");
		$table.append($header);
		console.log(data);	
		members.forEach(e=>{
			const $tr = $("<tr>");
			const $memberId = $("<td>").text(e['memberId']);
			const $memberNickName = $("<td>").text(e['memberNickName']);
			const $age = $("<td>").text(e['age']);
			const $email = $("<td>").text(e['email']);
			const $phone = $("<td>").text(e['phone']);
			const $enrolldate = $("<td>").text(e['enrollDate']);
			$tr.append($memberId)
			.append($memberNickName).append($age).append($email)
			.append($phone).append($enrolldate);
			$table.append($tr);
		});
		return $table;
}