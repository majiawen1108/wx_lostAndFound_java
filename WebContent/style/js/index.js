$(function(){
	$("#found").click(function () {
		var url = $(this).children('a').attr('href');
        $.ajax({
            type: 'GET',
            url:url,
            success: function (result) {
                $("#main").html(result);
            }
        });
        return false;
    });
})