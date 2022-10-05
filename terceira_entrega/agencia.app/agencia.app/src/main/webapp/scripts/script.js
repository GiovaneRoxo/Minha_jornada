const cpf = document.getElementById('cpf');
const email = document.getElementById('email');
const telefone = document.getElementsByTagName('telefone');

cpf.addEventListener('keypress', () => {
	let cpflength = cpf.value.length
	
   	if ( cpflength === 3 ||  cpflength === 7) {
		cpf.value += '.'
	} else if (cpflength === 11) {
		cpf.value += '-'
	}
})

telefone.addEventListener('keypress', () => {

    let telefoneLength = telefone.value.length;

    if ( telefoneLength === 0) {
        telefone.value += '('
    }
    if ( telefoneLength === 3) {
        telefone.value += ')'
    }
})

function somenteNumeros(num) {
        var er = /[^0-9.-]/;
        er.lastIndex = 0;
        var campo = num;
        if (er.test(campo.value)) {
          campo.value = "";
        }
}



function validarEmail(email){
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (email.match(mailformat)) {
        document.getElementById("email").setCustomValidity("");    
    }else{
        document.getElementById("email").setCustomValidity("Email inválido");
    }  
}