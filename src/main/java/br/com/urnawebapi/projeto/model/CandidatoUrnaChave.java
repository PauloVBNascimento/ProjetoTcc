package br.com.urnawebapi.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CandidatoUrnaChave implements Serializable {
    
    @Column(name= "idc")
    private Integer idc;

    @Column(name= "idu")
    private Integer idu;

    public Integer getIdc() {
        return idc;
    }

    public void setIdc(Integer idc) {
        this.idc = idc;
    }

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public CandidatoUrnaChave(Integer idc, Integer idu) {
        this.idc = idc;
        this.idu = idu;
    }

    public CandidatoUrnaChave () {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idc == null) ? 0 : idc.hashCode());
        result = prime * result + ((idu == null) ? 0 : idu.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CandidatoUrnaChave other = (CandidatoUrnaChave) obj;
        if (idc == null) {
            if (other.idc != null)
                return false;
        } else if (!idc.equals(other.idc))
            return false;
        if (idu == null) {
            if (other.idu != null)
                return false;
        } else if (!idu.equals(other.idu))
            return false;
        return true;
    }
    
}
