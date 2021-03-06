/* 
 * The MIT License
 *
 * Copyright 2017 wr.ravelo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.CobroMultaEntity;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author wr.ravelo
 */
@XmlRootElement
public class CobroMultaDetailDTO extends CobroMultaDTO
{
    /**
     * Usuario destinatario del cobro
     */
    @PodamExclude
    protected UsuarioDTO usuarioDestinatario;
    
    /**
     * Usuario remitente del cobro
     */
    @PodamExclude
    protected UsuarioDTO usuarioRemitente;
    
    /**
     * Crea un cobro multa detail dto
     */
    public CobroMultaDetailDTO()
    {
        super();
    }
       
    /**
     * Crea un cobro multa detail dto de una entidad.
     *
     * @param en Entidad de donde se va a crear el detail dto
     */
    public CobroMultaDetailDTO(CobroMultaEntity en) {
        super(en);
        this.usuarioDestinatario = new UsuarioDTO(en.getUsuarioDestinatario());
        this.usuarioRemitente = new UsuarioDTO(en.getUsuarioRemitente());
    }

    /**
     * Convirte una entidad a cobro multa detail dto.
     *
     * @return
     */
    @Override
    public CobroMultaEntity toEntity()
    {
        CobroMultaEntity x =  super.toEntity();
        x.setUsuarioDestinatario(this.getUsuarioDestinatario().toEntity());
        x.setUsuarioRemitente(this.getUsuarioRemitente().toEntity());
        return x;
    }
    
     /**
     * Da el usuario destinatario
     * @return Usuario destinatario
     */
    public UsuarioDTO getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    /**
     * Modifica el usuario destinatario
     * @param usuarioDestinatario Nuevo usuario destinatario
     */
    public void setUsuarioDestinatario(UsuarioDTO usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

    /**
     * Da el usuario remitente
     * @return Usuario remitente
     */
    public UsuarioDTO getUsuarioRemitente() {
        return usuarioRemitente;
    }

    /**
     * Modifica el usuario remitente
     * @param usuarioRemitente Nuevo usuario remitente.
     */
    public void setUsuarioRemitente(UsuarioDTO usuarioRemitente) {
        this.usuarioRemitente = usuarioRemitente;
    }
}
