$.getJSON("/reservas", function (data) {
    var sel = document.getElementById('mod');
    for (var i =0; i < data.length; i++ ){
        var opt = document.createElement('option');
        opt.appendChild(document.createTextNode(data[i].nome));
        opt.value = data[i].id;
        sel.appendChild(opt);
        console.log(opt.value)
    }
})

function checkFunction(){
    var select = document.getElementById('mod');
    var newURL = "/reservas/listar/" + select.value;
    console.log(newURL);
    $.getJSON(newURL, function (data) {
        var list = document.getElementById('lugar');
        for (var i = 0; i < data.length; i++) {
            var li = document.createElement('li');
            var div = document.createElement('div');
            var icon = document.createElement('i')
            icon.setAttribute('class',  'material-icons' );
            icon.appendChild(document.createTextNode('place'))
            console.log(icon.textContent);
            div.setAttribute('class', 'collapsible-header');
            div.appendChild(icon);
            div.appendChild(document.createTextNode(data[i].nome));
            console.log(div.textContent);
            li.setAttribute('onclick', 'loadHorario(id)')
            li.appendChild(div);
            li.id = data[i].id;
            list.appendChild(li);
        }
    })
}


function loadHorario(id) {
    var data = $('.datepicker').val();
    console.log(data);
    var aux = data.toString();
    var h = aux.split('/');
    var final = h[2]+'-'+h[1]+'-'+h[0];
    console.log(final);

    console.log(id);
    var newurl = id+'e'+final;
    console.log(newurl);

}
