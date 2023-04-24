import eu.epfc.prm2.Array;

public class Programme {
    public static int pos(Array<MedaillePays> mp, String pays) {
        int pos = -1;
        for (int i = 0; i < mp.size(); ++i) {
            if (mp.get(i).pays.compareTo(pays) == 0) pos = i;
        }
        return pos;
    }

    public static int newPos(Array<MedaillePays> mp, MedaillePays medaillePays) {
        int i = 0;
        while (i < mp.size() && mp.get(i).compareTo(medaillePays) > 0) {
            ++i;
        }
        return i;
    }

    public static void changePos(Array<MedaillePays> medailles, MedaillePays medaillePays, int pos, int newPos) {
        for (int k = pos; k > newPos; --k) {
            medailles.set(k, medailles.get(k - 1));
        }
        medailles.set(newPos, medaillePays);
    }

    public static void nouvelleMedaille(Array<MedaillePays> medailles, String pays) {
        int pos = pos(medailles, pays);
        if (pos == -1) {
            medailles.add(new MedaillePays(1, pays));
        } else {
            ++medailles.get(pos).medailles;
            MedaillePays medaillePays = medailles.get(pos);
            int newPos = newPos(medailles, medaillePays);
            changePos(medailles, medaillePays, pos, newPos);
        }
    }

    public static void affiche(Array<MedaillePays> medailles) {
        System.out.println("Médailles des pays :");
        for (MedaillePays m : medailles) {
            System.out.println(m);
        }
        System.out.println("============================================");
    }

    public static void main(String[] args) {
        Array<MedaillePays> medailles = new Array<>();
        nouvelleMedaille(medailles, "Belgique");
        affiche(medailles);
        nouvelleMedaille(medailles, "France");
        affiche(medailles);
        nouvelleMedaille(medailles, "France");
        affiche(medailles);
        nouvelleMedaille(medailles, "Allemagne");
        affiche(medailles);
        nouvelleMedaille(medailles, "Belgique");
        affiche(medailles);
        nouvelleMedaille(medailles, "Belgique");
        affiche(medailles);
        nouvelleMedaille(medailles, "Italie");
        affiche(medailles);
        nouvelleMedaille(medailles, "Espagne");
        affiche(medailles);
        nouvelleMedaille(medailles, "Italie");
        affiche(medailles);

    }

}