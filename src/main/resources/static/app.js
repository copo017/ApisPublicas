$(document).ready(function () {
    $('#searchForm').on('submit', function (e) {
        e.preventDefault();
        let pokemonName = $('#pokemonName').val().toLowerCase();
        if (pokemonName) {
            $.ajax({
                url: `http://localhost:8080/buscar-poke/${pokemonName}`,
                method: 'GET',
                success: function (data) {
                    let types = data.types.map(typeInfo => typeInfo.type.name).join(', ');
                    let stats = data.stats.map(statInfo => `
                                            <div class="col-md-4">
                                                <div class="card mb-3">
                                                    <div class="card-body">
                                                        <h5 class="card-title">${statInfo.stat.name}</h5>
                                                        <p class="card-text">Base Stat: ${statInfo.base_stat}</p>
                                                        <p class="card-text">Effort: ${statInfo.effort}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        `).join('');
                    $('#pokemonInfo').html(`
                        <h3>${data.name}</h3>
                        <div class="row mt-4">
                            <div class="col-md-12">
                                 <img src="${data.sprites.front_default}" class="img-fluid" alt="${data.name}">
                            </div>
                        </div>
                        <p><strong>ID:</strong> ${data.id}</p>
                        <p><strong>Altura:</strong> ${data.height}</p>
                        <p><strong>Peso:</strong> ${data.weight}</p>
                        <p><strong>Tipos:</strong> ${types}</p>
                        <div class="row">
                            ${stats}
                        </div>
                    `);
                },
                error: function () {
                    $('#pokemonInfo').html('<p class="text-danger">Pokémon no encontrado</p>');
                }
            });
        }
    });
});
