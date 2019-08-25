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

            li.appendChild(div);
            li.id = data[i].id;
            list.appendChild(li);
        }
    })
}
function load() {
    var select = document.getElementById('mod');
    var urlLocais = "/reservas/listar/" + select.value;
    console.log(urlLocais);
    $.getJSON(urlLocais, function (locais) {
        for (var i = 0; i < locais.length; i++) {
            var list = document.getElementById(locais[i].id);
            var div = document.createElement('div');
            div.setAttribute('class', 'collapsible-body');
            div.id=locais[i].id;
            var ini = 9;
            var fim = 11;
            for (; fim < 22; fim++, ini++) {
                var p = document.createElement('p');
                var label = document.createElement('label');
                var input = document.createElement('input');
                input.setAttribute('type', 'checkbox');
                label.appendChild(input);
                var span = document.createElement('span');
                span.appendChild(document.createTextNode(ini+':00 a '+fim+':00'));
                label.appendChild(span);
                p.appendChild(label);
                div.appendChild(p);
            }
            var button = document.createElement('button');
            button.setAttribute('action', 'saveToSwitch(id)' );
            button.setAttribute('id', locais[i].nome);
            button.setAttribute('class', 'btn waves-effect waves-light');
            button.setAttribute('type', 'submit');
            button.setAttribute('name', 'action');
            button.appendChild(document.createTextNode('Finalizar Reserva'));
            var icon = document.createElement('i');
            icon.setAttribute('class', 'material-icons right');
            icon.appendChild(document.createTextNode('send'));
            button.appendChild(icon);


            div.appendChild(button);
            list.appendChild(div);
            console.log(list);
        }
    })


}
function loadHorario(id, v) {
    if (v == true){
        return;
    }
    var div = document.getElementById(id);
    var data = $('.datepicker').val();
    var aux = data.toString();
    var help = aux.split('/');
    var url = '/reservas/listarHorarios/'+id+'e'+help[2]+'-'+help[1]+'-'+help[0]
    console.log(url);
    $.getJSON(url, function (horarios) {
        var ini = 9;
        var fim = 10;
        for (var i = 0; i < horarios.length; i++) {
            var p = document.createElement('p');
            var label = document.createElement('label');
            var input = document.createElement('input');
            input.setAttribute('type', 'checkbox');
            label.appendChild(input);
            var span = document.createElement('span');
            span.appendChild(document.createTextNode(ini+':00 a '+fim+':00'));
            ini = ini +1;
            fim = fim + 1;
            label.appendChild(span);
            p.appendChild(label);
            div.appendChild(p);
        }
    })
    var li = document.getElementById(id);
    li.setAttribute('onclick()', '');
    console.log(div);
}

function saveToSwitch(id){
    var modalidade = document.getElementById('mod').value;
    var data = $('.datepicker').val();
    var nome_quadra = id;
    console.log(modalidade,nome_quadra,data)
    document.location.href = "/fim";
    var h3 = document.getElementById(local_res);
    h3.appendChild(document.createTextNode('id'));

}
