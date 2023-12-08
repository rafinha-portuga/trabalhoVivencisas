
//feito para pagina cupom
document.addEventListener('DOMContentLoaded', function () {
    // faz com que os botões da pagina cumpom ganhe a função copiar 'copy-button'
    var copyButtons = document.querySelectorAll('.copy-button');

    copyButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            
            var cupomCode = button.getAttribute('data-code');

           
            var input = document.createElement('input');
            input.value = cupomCode;
            document.body.appendChild(input);

            // Seleciona e copia o texto
            input.select();
            document.execCommand('copy');

            
            document.body.removeChild(input);

            // Adiciona um alerta
            alert('Cupom copiado: ' + cupomCode);
        });
    });

//Pagina de cadastro de cupom
    document.addEventListener('DOMContentLoaded', function () {
        const cupomForm = document.getElementById('cupomForm');
        const produtoInput = document.getElementById('produto');
        const valorDescontoInput = document.getElementById('valorDesconto');
        const cupomInput = document.getElementById('cupom');
        const cnpjInput = document.getElementById('cnpj');

        cupomForm.addEventListener('submit', function (event) {
            event.preventDefault();

            // Isso é para obter os valores dos campos
            const produto = parseFloat(produtoInput.value);
            const valorDesconto = parseFloat(valorDescontoInput.value);
            const cupom = cupomInput.value;
            const cnpj = parseInt(cnpjInput.value);

            // impede o usuario de digitar letras
            if (isNaN(produto) || isNaN(valorDesconto) || isNaN(cnpj)) {
                alert('Por favor, insira valores numéricos válidos.');
                return;
            }

            if (valorDesconto < 0 || valorDesconto > 100) {
                alert('O valor do desconto deve estar entre 0 e 100%.');
                return;
            }

            
            // Limpa os campos apos cadastrar
            produtoInput.value = '';
            valorDescontoInput.value = '';
            cupomInput.value = '';
            cnpjInput.value = '';
        });
    });
});

// Isso faz a parte da pagina de cadastro que enviar dados para o backend

document.addEventListener('DOMContentLoaded', function () {
    const cupomForm = document.getElementById('cupomForm');

    cupomForm.addEventListener('submit', function (event) {
        event.preventDefault();

        // Obtenha os valores dos campos do formulário
        const produto = document.getElementById('produto').value;
        const valorDesconto = document.getElementById('valorDesconto').value;
        const cupom = document.getElementById('cupom').value;
        const loja = document.getElementById('loja').value;

        // Construa um objeto com os dados do cupom
        const novoCupom = {
            descontoPercentual: parseFloat(valorDesconto),
            codigoCupom: cupom,
            loja: {
                idLoja: loja
            },
            produto: {
                idProduto: produto
            }
        };
        
        enviarCupomParaBackend(novoCupom);
    });

    function enviarCupomParaBackend(cupom) {
        // Substitua a URL abaixo pela URL backend para cadastrar cupons
        const backendURL = 'http://localhost:8080/cupons';

        fetch(backendURL, {
            method: 'POST',
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(cupom)
        })
        .then(response => {
            if (response.ok) { 
                alert('Cupom cadastrado com sucesso!');
            } else {
                alert('Erro ao cadastrar o cupom. Por favor, tente novamente.');
            }
        })
        .catch(error => {
            console.error('Erro ao cadastrar o cupom:', error);
            alert('BAD REQUEST.');
        });
    }
});



// Função para obter os cupons do backend, só deixei montada do jeito que vi na internet, mas não testei


document.addEventListener('DOMContentLoaded', function () {
    
    function getCuponsFromBackend() {
        const backendURL = 'http://localhost:8080/cupons';

        return fetch(backendURL, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
            })
            .then(response => response.json())
            .catch(error => {
                console.error('Erro ao obter cupons do backend:', error);
                return [];
            });
    }

    // Função que permite o cupom renderizar na pagina principal saca?
    function renderizarCupons(cupons) {
        const cuponsContainer = document.getElementById('cuponsContainer');


        // Renderizar cada cupom
        cupons.forEach(cupom => {
            const cupomDiv = document.createElement('div');
            cupomDiv.classList.add('cupom-card');
            cupomDiv.innerHTML = `
                <h2>${cupom.produto}</h2>
                <p>Desconto: ${cupom.valorDesconto}%</p>
                <p>Código do Cupom: ${cupom.codigo}</p>
            `;
            cuponsContainer.appendChild(cupomDiv);
        });
    }

    // Carregar e renderizar os cupons ao carregar a página
    getCuponsFromBackend().then(renderizarCupons);
});
