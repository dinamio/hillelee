$(document).ready(function(){
    var i=1;
    $("#add_row").click(function(){
        $('#addr'+i).html("<td>"+ (i+1) +"</td><td><input name='answer"+i+"' type='text' placeholder='Answer' class='form-control input-md' required='required' /></td><td><div class='col-md-4'><div class='checkbox checkbox-primary'><input name='check"+i+"' id='checkbox"+i+"' type='checkbox'><label for='checkbox"+i+"'>check if true </label></div></div></td>");

        $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
        i++;
    });
    $("#delete_row").click(function(){
        if(i>1){
            $("#addr"+(i-1)).html('');
            i--;
        }
    });

});