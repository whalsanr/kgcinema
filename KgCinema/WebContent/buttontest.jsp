<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="./js/EditJS.js"></script>
<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
</head>
<body>
<form id="form1" runat="server">
    <input type='file' id="inputFile" />
    <img class="sadasd" id="image_upload_preview" src="http://placehold.it/100x100" name="aaa"/>
</form>

<script>
$(document).ready(function() {
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#image_upload_preview').attr('src', e.target.result);
            $('#image_upload_preview').attr('name', escape(e.name));
            $('#image_upload_preview').css({'width' : '100px'});
            $('#image_upload_preview').css({'height' : '100px'});
        }
        reader.readAsDataURL(input.files[0]);
    }
}

$("#inputFile").change(function () {
    readURL(this);
});
});
</script>
</body>
</html>