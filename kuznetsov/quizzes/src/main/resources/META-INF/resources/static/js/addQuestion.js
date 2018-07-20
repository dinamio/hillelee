function addRow(input) {
    var table = document.getElementById("myTable");
    var i = parseInt(input.id.substring(3, input.id.length));
    document.getElementById('icon' + i).className = "glyphicon glyphicon-minus";
    var row = table.insertRow(table.rows.length);
    row.id = "row" + (i + 1);
    var cell = row.insertCell(0);
    cell.innerHTML = '<div class="input-group">'+
        '<input type="checkbox" class="check-box-table-cell"  name="Checkbox'+(i+1)+'">'+
        '<input type="text" class="form-control" name="Question'+(i+1)+'">'+
        '<span class="input-group-btn">'+
        '<button id="btn'+(i+1)+'" type="button" class="btn btn-primary" onclick="addRow(this)">'+
        '<span id="icon'+(i+1)+'" class="glyphicon glyphicon-plus"></span>'+
        '</button>'+
        '</span>'+
        '</div>';
    $('#btn'+i).attr('onclick', 'remRow(this)');
}

function remRow(input) {
    var table = document.getElementById("myTable");
    var i = parseInt(input.id.substring(3, input.id.length));
    var ind = table.rows["row" +i].rowIndex;
    table.deleteRow(ind);
}
