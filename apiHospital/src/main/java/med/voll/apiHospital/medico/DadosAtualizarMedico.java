package med.voll.apiHospital.medico;

import med.voll.apiHospital.endereco.Endereco;

public record DadosAtualizarMedico(Long id, String nome, String telefone, Endereco endereco) {
}
