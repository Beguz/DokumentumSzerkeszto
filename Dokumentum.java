package dokumentum;

public class Dokumentum {

    protected String szoveg;

    public Dokumentum() {
        this.szoveg = "";
    }

    public Dokumentum(String dok) {
        if (dok != null) {
            this.szoveg = dok;
        } else {
            this.szoveg = "";
        }

    }

    public String getSzoveg() {
        if (this.szoveg != null) {
            return this.szoveg;
        } else {
            return "";
        }
    }

    public void setSzoveg(String uj) {
        if (uj != null) {
            this.szoveg = uj;
        }

    }

    public int getHossz() {
        return this.szoveg.length();
    }

    public int getSorokSzama() {
        String[] sorok = this.szoveg.split("\r\n|\r|\n");
        return sorok.length;
    }

    public String getSor(int sorv) {
        String[] sorok = this.szoveg.split("\r\n|\r|\n");
        if (sorv > sorok.length - 1) {
            return null;
        }
        return sorok[sorv - 1];
    }

    public SzerkeszthetoDokumentum szerkeszthetoValtozat() {
        SzerkeszthetoDokumentum uj = new SzerkeszthetoDokumentum();
        uj.szoveg = this.szoveg;
        return uj;
    }

}
