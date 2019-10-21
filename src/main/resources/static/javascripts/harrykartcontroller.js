$(document).ready(function(){

  $('form[id="playForm"] ').submit(function(){
    var data = $(this).find("textarea").val();
    $.ajax({
      method:"POST",
      url: "/api/play",
      contentType: "application/xml; charset=UTF-8",
      dataType: "text",
      data: data,
      processData: false,
      success: function(result){
        $("#playResult").text(JSON.stringify(JSON.parse(result), null, 2));
      },
      error: function (jqXHR, textStatus, errorThrown) {
        $("#playResult").text("Error code: " + errorThrown + "\n"
          + "responseText: " + jqXHR.responseText);
      }
    });
    return false;
  });

});