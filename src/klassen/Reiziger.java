package klassen;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reiziger")
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int reiziger_id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;

    @OneToOne(mappedBy="reiziger")
    private Adres adres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reiziger")
    private List<OVChipkaart> ovchipkaarten = new ArrayList<>();

    public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.reiziger_id = reiziger_id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public Reiziger() {
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setAdres(Adres a) {
        adres = a;
    }

    public Adres getAdres() {
        return adres;
    }

    public List<OVChipkaart> getOvchipkaarten() {
        return ovchipkaarten;
    }

    public void setOvchipkaarten(List<OVChipkaart> ovchipkaarten) {
        this.ovchipkaarten = ovchipkaarten;
    }

    public void addOvchipkaart(OVChipkaart ovchipkaart) {
        if (!ovchipkaarten.contains(ovchipkaart)) {
            ovchipkaarten.add(ovchipkaart);
        }
    }

    @Override
    public String toString(){
        return "Reiziger{" +
                "reiziger_id=" + reiziger_id +
                ", voorletters='" + voorletters + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
//                ", geboortedatum=" + geboortedatum +
//                ", adres=" + adres +
//                ", ovchipkaart=" + ovchipkaarten +
                '}';
    }
}
