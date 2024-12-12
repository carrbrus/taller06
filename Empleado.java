
import java.util.List;

public class Empleado {
    private String nombre;
    private String genero;
    private double salarioBase;
    private int horasTrabajadas;
    private String departamento;
    private double tarifaHora;

    public Empleado(){}
    public Empleado(String nombre, double salarioBase, int horasTrabajadas, double tarifaHora, String departamento) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
        this.departamento = departamento;
    }

    public double calcularSalario() {
        validarSalarioYHoras();
        double salarioTotal = salarioBase + calcularHorasExtra();
        salarioTotal += calcularBonoPorDepartamento();
        return salarioTotal;
}

        private void validarSalarioYHoras() {
            if (salarioBase <= 0) {
                throw new IllegalArgumentException("El salario debe ser mayor o igual a 0");
            }
            if (horasTrabajadas < 0) {
                throw new IllegalArgumentException("Las horas trabajadas deben ser mayor o igual a 0");
            }
        }

        private double calcularHorasExtra() {
            return (horasTrabajadas > 40) ? (horasTrabajadas - 40) * 50 : 0;
        }

        private double calcularBonoPorDepartamento() {
            return switch (departamento) {
                case "Sistemas" -> 20;
                case "Contabilidad" -> 10;
                default -> 0;
            };
}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Genero: " + genero);
        System.out.println("Salario: " + calcularSalario());
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Departamento: " + departamento);
}
    public static Empleado buscarEmpleadoPorNombre(String nombre, List<Empleado> empleados) {
    return empleados.stream()
            .filter(empleado -> empleado.getNombre().equals(nombre))
            .findFirst()
            .orElse(null);
}

}


