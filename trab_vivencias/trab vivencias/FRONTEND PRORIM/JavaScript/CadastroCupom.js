//Pagina de cadastro de cupom
document.addEventListener('DOMContentLoaded', function () {
    const loja = document.getElementById('loja');
    const produto = document.getElementById('produto');
    const cupom = document.getElementById('cupom');
    const valorDesconto = document.getElementById('valorDesconto');

    cupomForm.addEventListener('submit', function (event) {
        event.preventDefault();

        if (isNaN(produto.value) || isNaN(valorDesconto.value)) {
            alert('Por favor, insira valores numéricos válidos.');
            return;
        }

        if (valorDesconto < 0 || valorDesconto > 100) {
            alert('O valor do desconto deve estar entre 0 e 100%.');
            return;
        }
        const url = "http://localhost:8080/cupons";
        const data = { loja: {
            "idLoja": parseInt(loja.value)
          },
            produto: {
                "idProduto": parseInt(produto.value)
              },
            descontoPercentual: parseFloat(valorDesconto.value), 
            codigoCupom: cupom.value, }
        fetch(url, {
            method: "POST",
            mode: "cors",
            cache: "no-cache",
            credentials: "same-origin",
            headers: {
              "Content-Type": "application/json",
            },
            redirect: "follow",
            referrerPolicy: "no-referrer",
            body: JSON.stringify(data),
          });
          
        loja.value = '';
        produto.value = '';
    })
});
