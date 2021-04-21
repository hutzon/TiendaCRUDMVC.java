
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConsultaPersonas;
import modelo.Persona;
import vista.VistaPersona;


public class ControladorPersona implements ActionListener{
   
    private VistaPersona vista;
    private ConsultaPersonas modelo;
    private Persona persona;

    public ControladorPersona(VistaPersona vista, ConsultaPersonas modelo, Persona persona) {
        this.vista = vista;
        this.modelo = modelo;
        this.persona = persona;
        
        vista.botonInsertar.addActionListener(this);
        vista.botonLimpiar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonModificar.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
    }
    
    public void inicia(){
        vista.setTitle("Tienda");
        vista.setLocationRelativeTo(null);
        vista.cajaId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.botonInsertar){
            persona.setClave(vista.cajaClave.getText());
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreo(vista.cajaCorreo.getText());
            persona.setFecha(Date.valueOf(vista.cajaFecha.getText()));
            persona.setGenero(vista.cajaGenero.getSelectedItem().toString());
            
            
        if(modelo.insertar(persona)){
            JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
            limpiarCajas();
            
        }else{
            JOptionPane.showMessageDialog(null, "Registro NO insertado");
            limpiarCajas();
        }   
        
        }
        
        if(ae.getSource()==vista.botonLimpiar){
            limpiarCajas();
        }
        
        if(ae.getSource()==vista.botonBuscar){
            persona.setClave(vista.cajaBuscar.getText());
            
            if(modelo.buscar(persona)){
                vista.cajaId.setText(String.valueOf(persona.getIdPersona()));
                vista.cajaClave.setText(persona.getClave());
                vista.cajaNombre.setText(persona.getNombre());
                vista.cajaCelular.setText(persona.getCelular());
                vista.cajaFecha.setText(String.valueOf(persona.getFecha()));
                vista.cajaCorreo.setText(persona.getCorreo());
                vista.cajaDomicilio.setText(persona.getDomicilio());
                vista.cajaGenero.setSelectedItem(persona.getGenero());
            }else{
                JOptionPane.showMessageDialog(null, "No existe una persona con esa clave");
                limpiarCajas();
            }
            
        }
        
        if(ae.getSource()==vista.botonModificar){
            persona.setIdPersona(Integer.valueOf(vista.cajaId.getText()));
            persona.setClave(vista.cajaClave.getText());
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreo(vista.cajaCorreo.getText());
            persona.setFecha(Date.valueOf(vista.cajaFecha.getText()));
            persona.setGenero(vista.cajaGenero.getSelectedItem().toString());
            
            if(modelo.modificar(persona)){
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                limpiarCajas();
            }
            
        }
        
        if(ae.getSource()==vista.botonEliminar){
            persona.setIdPersona(Integer.parseInt(vista.cajaId.getText()));
            
            if(modelo.eliminar(persona)){
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                limpiarCajas();
            }
        }
    
    }
    
    
    public void limpiarCajas(){
        vista.cajaId.setText(null);
        vista.cajaBuscar.setText(null);
        vista.cajaClave.setText(null);
        vista.cajaNombre.setText(null);
        vista.cajaDomicilio.setText(null);
        vista.cajaCelular.setText(null);
        vista.cajaCorreo.setText(null);
        vista.cajaFecha.setText(null);
        vista.cajaGenero.setSelectedIndex(0);
    }
    
    
}
