
/****************
 * �����ύform���ž�get��ʽ������
 * @param json
 * @param url
 * @param method
 */
function autoSubmit(json,url){
	var myForm = document.createElement("form");
	document.body.appendChild(myForm);
	myForm.method="post";
	myForm.action=url;
	if(""!=json && null!=json){
		for ( var item in json) {
			var myInput = document.createElement("input");
			myInput.type = "hidden";
			myInput.value = json[item];
			myInput.name = item;
			myForm.appendChild(myInput);
		}
	}
	//���ύ
	myForm.submit();
}