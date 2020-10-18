var sum=1;
function displayWindow(){
	document.getElementById("add_list").style.display="flex";
	document.getElementById("add_list").style.flexDirection="column";
	document.getElementById("shadow").style.display="block";
}
function hideWindow(){
	document.getElementById("add_list").style.display="none";
	document.getElementById("shadow").style.display="none";
}
function addList(){
	var name=document.getElementById("name").value;
	var phone=document.getElementById("phone").value;
	var email=document.getElementById("email").value;
	var address=document.getElementById("address").value;
	var qq=document.getElementById("qq").value;
	
	var email_re=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	var phone_re=/^(13[0-9]\d{8}|15[0-35-9]\d{8}|18[0-9]\{8}|14[57]\d{8})$/;
	var qq_re=/^[0-9]{5,10}$/;
	if(!email_re.test(email)){
		alert("电子邮件格式不正确");
	}
	else if(!phone_re.test(phone)){
		alert("电话格式不正确");
	}
	else if(!qq_re.test(qq)){
		alert("qq格式不正确");
	}
	else{
		console.log(123)
		sum++;
		
		var ul1=document.createElement('ul');
		
		var li1=document.createElement('li');
		var li1_=document.createElement('p');
		li1_.innerHTML=sum;
		li1.appendChild(li1_);
		var li2=document.createElement('li');
		var li2_=document.createElement('p');
		li2_.innerHTML=name;
		li2.appendChild(li2_);
		var li3=document.createElement('li');
		var li3_=document.createElement('p');
		li3_.innerHTML=phone;
		li3.appendChild(li3_);
		var li4=document.createElement('li');
		var li4_=document.createElement('p');
		li4_.innerHTML=email;
		li4.appendChild(li4_);
		var li5=document.createElement('li');
		var li5_=document.createElement('p');
		li5_.innerHTML=address;
		li5.appendChild(li5_);
		var li6=document.createElement('li');
		var li6_=document.createElement('p');
		li6_.innerHTML=qq;
		li6.appendChild(li6_);
		
		var btn1=document.createElement('button');
		btn1.innerHTML="删除";
		var btn2=document.createElement('button');
		btn2.innerHTML="修改";
		btn1.className="btn";
		btn2.className="btn";
		ul1.appendChild(li1);
		ul1.appendChild(li2);
		ul1.appendChild(li3);
		ul1.appendChild(li4);
		ul1.appendChild(li5);
		ul1.appendChild(li6);
		ul1.appendChild(btn1);
		ul1.appendChild(btn2);
		ul1.className="list";
		var l=document.getElementsByClassName("left")[0];
		l.appendChild(ul1);
		
		document.getElementById("add_list").style.display="none";
		document.getElementById("shadow").style.display="none";
	}
}