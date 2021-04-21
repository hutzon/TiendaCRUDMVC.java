
package crud_mvc_tienda;

import controlador.ControladorPersona;
import modelo.ConsultaPersonas;
import modelo.Persona;
import vista.VistaPersona;


public class CRUD_MVC_Tienda {

    
    public static void main(String[] args) {
        VistaPersona vista = new VistaPersona();
        ConsultaPersonas modelo = new ConsultaPersonas();
        Persona persona = new Persona();
        ControladorPersona controlador = new ControladorPersona(vista, modelo, persona);
        
        controlador.inicia();
        vista.setVisible(true);
        
        
        
    }
    
}
