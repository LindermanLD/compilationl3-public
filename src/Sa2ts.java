import sa.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

    private Ts tableGlobale;
    private Ts tableCourante;

    public Sa2ts(SaNode saNode) {
        tableGlobale = new Ts();
        tableCourante = this.tableGlobale;
        saNode.accept(this);
    }

    public Ts getTableGlobale() {
        tableGlobale.affiche(System.out);
        return tableGlobale;
    }

    public Void visit(SaDecTab node) {
        if (tableGlobale.getVar(node.getNom()) == null)
            tableGlobale.addVar(node.getNom(), node.getTaille());
        return null;
    }

    public Void visit(SaDecFonc node) {
        if (tableCourante.getFct(node.getNom()) == null) {
            this.tableCourante = new Ts();

            SaLDec listParametres = node.getParametres();
            int taille = 0;
            if (listParametres != null) {
                taille = listParametres.length();
                for (int i = 0; i < taille; ++i) {
                    tableCourante.addParam(listParametres.getTete().getNom());
                    listParametres = listParametres.getQueue();
                }
            }
            if (node.getVariable() != null) {
                node.getVariable().accept(this);
            }
            this.tableGlobale.addFct(node.getNom(), taille, this.tableCourante, node);
        }
        return null;
    }

    public Void visit(SaDecVar node) {
        if (tableCourante.getVar(node.getNom()) == null) {
            if (node.tsItem == null) {
                tableCourante.addVar(node.getNom(), 1);
            } else {
                if (node.tsItem.isParam)
                    tableCourante.addParam(node.getNom());
                else
                    tableCourante.addVar(node.getNom(), 1);
            }
        }
        return null;
    }


    public Void visit(SaVarSimple node) {
        if (node.tsItem.portee != this.tableGlobale) {
            Ts tableLocale = tableGlobale.getTableLocale(node.tsItem.portee.toString());
            TsItemVar parametre = tableLocale.getVar(node.getNom());
            if (node.tsItem.isParam) {
                if (parametre != null)
                    node.tsItem = parametre;
            } else {
                if (parametre != null)
                    node.tsItem = parametre;
            }
        } else {
            TsItemVar varGlobale = this.tableGlobale.getVar(node.getNom());
            if (varGlobale != null)
                node.tsItem = varGlobale;
        }
        this.tableGlobale.addVar(node.getNom(), node.tsItem.getTaille());
        return null;
    }

    public Void visit(SaAppel node) {
        TsItemFct itemFunction = this.tableGlobale.getFct(node.getNom());
        if (itemFunction != null)
            node.tsItem = itemFunction;
        return null;
    }

    public Void visit(SaVarIndicee node) {
        TsItemVar itemmVar = this.tableGlobale.getVar(node.getNom());
        if (itemmVar != null)
            node.tsItem = itemmVar;
        return null;
    }
}