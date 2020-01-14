function trim (str) {
    var str1 = str.replace(/^\s\s*/, ''),
    ws = /\s/,
    i = str1.length;
    while (ws.test(str1.charAt(--i)));
    return str1.slice(0, i + 1);
}

function checkNumber(evt) {
    evt = (evt) ? evt : window.event ;
    var charCode = (evt.which) ? evt.which : evt.keyCode ;
    //alert(charCode);
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

function checkValidChar(evt) {
    evt = (evt) ? evt : window.event ;
    var charCode = (evt.which) ? evt.which : evt.keyCode ;
    if (charCode == 34 || charCode == 60 || charCode == 62 || charCode == 44 ) {
        //"<>
        return false;
    }
    return true;
}

function toCaps(o){
    o.value=o.value.toUpperCase();
}

function valButton(btn) {
    var cnt = -1;
    for (var i=btn.length-1; i > -1; i--) {
        if (btn[i].checked) {
            cnt = i; i = -1;
        }
    }
    if (cnt > -1) return btn[cnt].value;
    else return null;
}

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
    var mlength= obj.getAttribute ? parseInt(obj.getAttribute("maxlength")) : ""
    if (obj.getAttribute && obj.value.length>mlength)
        obj.value=obj.value.substring(0,mlength)
}

function disableInput(evt) {
    evt = (evt) ? evt : window.event ;
    var charCode = (evt.which) ? evt.which : evt.keyCode ;
    switch(charCode) {
        case 46:  // delete
        case 8:  // backspace
            break;
        default:
            evt.preventDefault();
            break;
    }
}