function displayAddWindow(){
    document.getElementById("add_list").style.display="flex";
    document.getElementById("add_list").style.flexDirection="column";
    document.getElementById("shadow").style.display="block";
    document.getElementById("name").value="";
    document.getElementById("phone").value="";
    document.getElementById("email").value="";
    document.getElementById("address").value="";
    document.getElementById("qq").value="";
}
function displayChangeWindow(){
    document.getElementById("change_list").style.display="flex";
    document.getElementById("change_list").style.flexDirection="column";
    document.getElementById("shadow").style.display="block";
}
function deleteItem(id){
    var flag=confirm("确认删除?");
    if(flag){
        window.location.replace("/deleteItem?itemId="+id);
    }
}
function changeItem(id,name,phone,email,address,qq){
    displayChangeWindow();
    document.getElementById("_id").value=id;
    document.getElementById("_name").value=name;
    document.getElementById("_phone").value=phone;
    document.getElementById("_email").value=email;
    document.getElementById("_address").value=address;
    document.getElementById("_qq").value=qq;
}
function hideWindow(){
    document.getElementById("add_list").style.display="none";
    document.getElementById("shadow").style.display="none";
    document.getElementById("change_list").style.display="none";
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
        return false;
    }
    else if(!phone_re.test(phone)){
        alert("电话格式不正确");
        return false;
    }
    else if(!qq_re.test(qq)){
        alert("qq格式不正确");
        return false;
    }
    else{
        return true;
        document.getElementById("add_list").style.display="none";
        document.getElementById("shadow").style.display="none";
    }
}