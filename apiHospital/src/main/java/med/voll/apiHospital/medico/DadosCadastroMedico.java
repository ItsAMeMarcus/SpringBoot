package med.voll.apiHospital.medico;

import med.voll.apiHospital.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
