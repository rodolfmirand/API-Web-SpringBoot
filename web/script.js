const formulario = document.querySelector("form")
const input_nome = document.querySelector(".nome")
const input_email = document.querySelector(".email")
const input_senha = document.querySelector(".senha")
const input_telefone = document.querySelector(".tel")

function cadastrar(){
    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: input_nome.value,
                email: input_email.value,
                senha: input_senha.value,
                telefone: input_telefone.value
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
};

function limpar(){
    input_nome.value = "";
    input_email.value = "";
    input_senha.value = "";
    input_telefone.value = "";
};

formulario.addEventListener('submit', function(event){
    event.preventDefault();

    cadastrar();
    limpar();
});