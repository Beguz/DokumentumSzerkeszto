package dokumentum;

public class SzerkeszthetoDokumentum extends Dokumentum {

    public SzerkeszthetoDokumentum(String dok) {
        super(dok);
    }

    public SzerkeszthetoDokumentum() {
    }

    public void beszur(int poz, String uj) {
        if (poz < 0 || poz > this.szoveg.length() - 1 || uj == null) {
            return;
        }
        String memo = this.szoveg.substring(poz);
        this.szoveg = this.szoveg.replace(memo, "");
        this.szoveg += uj;
        this.szoveg += memo;
    }

    public void torol(int poz, int len) {
        if (poz < 0 || poz > this.szoveg.length() - 1) {
            return;
        }
        String temp = this.szoveg.substring(poz, poz + len);
        this.szoveg = this.szoveg.replace(temp, "");
    }

    public void cserel(int poz, int len, String uj) {
        if (poz > this.szoveg.length() - 1 || uj == null) {
            return;
        }
        this.torol(poz, len);
        String memo = this.szoveg.substring(poz);
        this.szoveg = this.szoveg.replace(memo, "");
        this.szoveg += uj;
        this.szoveg += memo;

    }

    public void hozzafuz(String uj) {
        if (uj == null) {
            return;
        }
        this.szoveg += uj;
    }

    public void sorTorol(int index) {
        String[] sorok = this.szoveg.split("\r\n|\r|\n");
        if (index > sorok.length - 1) {
            return;
        }
        if (index == 0) {
            this.szoveg = this.szoveg.replace(sorok[index], "");
            return;
        }
        this.szoveg = this.szoveg.replace("\n" + sorok[index], "");
    }

    public void sorBeszur(int index, String ujSor) {
        if (ujSor == null) {
            return;
        }
        if (index == 0) {
            this.szoveg = ujSor + this.szoveg;
            return;
        }

        String[] sorok = this.szoveg.split("\r\n|\r|\n");
        String temp = "";
        if (index > sorok.length) {
            return;
        }
        for (int i = index; i < sorok.length; i++) {
            temp += "\n" + sorok[i];
        }

        this.szoveg = this.szoveg.replace(temp, "");

        this.szoveg += "\n" + ujSor;
        this.szoveg += temp;
    }

}
