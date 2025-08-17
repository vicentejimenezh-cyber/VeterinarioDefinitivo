package co.edu.uniquindio.edu.poo.vet.Model;

public class ConsultaMedica {
    private AgendaCitaMedica agendacitamedica;
    private String diagnostico;
    private String tratamiento;

    public ConsultaMedica(AgendaCitaMedica agendacitamedica, String diagnostico,  String tratamiento) {
        this.agendacitamedica = agendacitamedica;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;

    }

    public AgendaCitaMedica getAgendacitamedica() {
        return agendacitamedica;
    }
    public void setAgendacitamedica(){
        AgendaCitaMedica agendacitamedica;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }




}
