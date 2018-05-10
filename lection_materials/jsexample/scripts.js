$(document).ready(function(){
  $("p").click(function() {
    $(this).hide();
  });
  $("#button").click(function() {
    var $newdiv1 = $( "<div id='object1'></div>" ),
  newdiv2 = document.createElement( "div" ),
  existingdiv1 = document.getElementById( "foo" );

$( "body" ).append( $newdiv1, [ newdiv2, existingdiv1 ] );
  });
});
