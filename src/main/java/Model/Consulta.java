package Model;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Consulta {
    private int id;
    private Date data;
    private String horario;
    private String comentario;
    private int id_animal;
    private int id_vet;
    private int id_tratamento;
    private boolean terminado;

    public Consulta(int id, Date data, String horario, String comentario, int id_animal, int id_vet, int id_tratamento, boolean terminado) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.comentario = comentario;
        this.id_animal = id_animal;
        this.id_vet = id_vet;
        this.id_tratamento = id_tratamento;
        this.terminado = terminado;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }
    
     public String getAno() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public String getDia() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String getMes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return String.valueOf(calendar.get(Calendar.MONTH) + 1);
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public boolean setAno(String ano) {
        try {
            int intAno = Integer.parseInt(ano);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data);
            calendar.set(Calendar.YEAR, intAno);

            data = calendar.getTime();
            return true;
        } catch (NumberFormatException e) {
            // Caso a conversão falhe
            return false;
        }
    }

    // Método para definir o mês da consulta a partir de uma string
    public boolean setMes(String mes) {
        try {
            int intMes = Integer.parseInt(mes);

            if (intMes >= 1 && intMes <= 12) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(data);
                // Subtraindo 1 porque os meses no Calendar começam de 0 (janeiro é 0)
                calendar.set(Calendar.MONTH, intMes - 1);

                data = calendar.getTime();
                return true;
            } else {
                // Valor do mês inválido
                return false;
            }
        } catch (NumberFormatException e) {
            // Caso a conversão falhe
            return false;
        }
    }

    // Método para definir o dia da consulta a partir de uma string
    public boolean setDia(String dia) {
        try {
            int intDia = Integer.parseInt(dia);

            if (intDia >= 1 && intDia <= 31) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(data);
                calendar.set(Calendar.DAY_OF_MONTH, intDia);

                data = calendar.getTime();
                return true;
            } else {
                // Valor do dia inválido
                return false;
            }
        } catch (NumberFormatException e) {
            // Caso a conversão falhe
            return false;
        }
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdAnimal() {
        return id_animal;
    }

    public void setIdAnimal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getIdVeterinario() {
        return id_vet;
    }

    public void setIdVeterinario(int id_vet) {
        this.id_vet = id_vet;
    }

    public int getIdTratamento() {
        return id_tratamento;
    }

    public void setIdTratamento(int id_tratamento) {
        this.id_tratamento = id_tratamento;
    }

    public boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", data=" + data +
                ", horario='" + horario + '\'' +
                ", comentario='" + comentario + '\'' +
                ", id_animal=" + id_animal +
                ", id_vet=" + id_vet +
                ", id_tratamento=" + id_tratamento +
                ", terminado=" + terminado +
                '}';
    }
}
