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

import co.edu.uniandes.csw.viajes.entities.AutomovilEntity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Danny
 */
@XmlRootElement
public class AutomovilDTO implements Serializable
{

    /**
     * atributo id
     */
    private Long id;
    /**
     * atributo placa
     */
    private String placa;
    /**
     * atributo marca
     */
    private String marca;
    /**
     * atributo modelo
     */
    private String modelo;
    /**
     * atributo cant asientos
     */
    private Integer cantAsientos;
    /**
     * atributo color
     */
    private String color;
    /**
     * atributo compañia de Seguros
     */
    private String compSeguros;
    /**
     * atributo numero de seguro
     */
    private Integer numSeguro;

    /**
     * constructor vacio
     */
    public AutomovilDTO()
    {
    }

    /**
     * constructor
     *
     * @param entity
     */
    public AutomovilDTO(AutomovilEntity entity)
    {
        if (entity != null)
        {
            this.id = entity.getId();
            this.placa = entity.getPlaca();
            this.cantAsientos = entity.getCantAsientos();
            this.color = entity.getColor();
            this.compSeguros = entity.getCompSeguros();
            this.marca = entity.getMarca();
            this.modelo = entity.getModelo();
            this.numSeguro = entity.getNumSeguro();
        }
    }

    /**
     * pasar de DTO a entity
     *
     * @return
     */
    public AutomovilEntity toEntity()
    {
        AutomovilEntity auto = new AutomovilEntity();
        auto.setCantAsientos(this.getCantAsientos());
        auto.setColor(this.getColor());
        auto.setCompSeguros(this.getCompSeguros());
        auto.setMarca(this.getMarca());
        auto.setModelo(this.getModelo());
        auto.setNumSeguro(this.getNumSeguro());
        auto.setPlaca(this.getPlaca());
        auto.setId(this.getId());
        return auto;

    }

    /**
     * dar el id
     *
     * @return id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * actualiza id
     *
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * dar la placa
     *
     * @return placa
     */
    public String getPlaca()
    {
        return placa;
    }

    /**
     * dar la marca
     *
     * @return marca
     */
    public String getMarca()
    {
        return marca;
    }

    /**
     * dar maodelo
     *
     * @return modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * dar cantidad de asientos
     *
     * @return cant asientos
     */
    public Integer getCantAsientos()
    {
        return cantAsientos;
    }

    /**
     * dar color
     *
     * @return color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * dar compSeguros
     *
     * @return
     */
    public String getCompSeguros()
    {
        return compSeguros;
    }

    /**
     * dar numero de seguro
     *
     * @return numSeguro
     */
    public Integer getNumSeguro()
    {
        return numSeguro;
    }

    /**
     * actualizar placa
     *
     * @param placa
     */
    public void setPlaca(String placa)
    {
        this.placa = placa;
    }

    /**
     * actualizar marca
     *
     * @param marca
     */
    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    /**
     * actualizar modelo
     *
     * @param modelo
     */
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    /**
     * actualizar cantidad de asientos
     *
     * @param cantAsientos
     */
    public void setCantAsientos(Integer cantAsientos)
    {
        this.cantAsientos = cantAsientos;
    }

    /**
     * actualizar color
     *
     * @param color
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * actualizar compañia de seguros
     *
     * @param compseguros
     */
    public void setCompSeguros(String compSeguros)
    {
        this.compSeguros = compSeguros;
    }

    /**
     * actualizar numero de seguro
     *
     * @param numSeguro
     */
    public void setNumSeguro(Integer numSeguro)
    {
        this.numSeguro = numSeguro;
    }
}
