import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {

    private SaNode returnValue;

    public SaNode getRoot() {
        return returnValue;
    }

    private SaNode apply(Switchable sc) {
        sc.apply(this);
        return returnValue;
    }

    @Override
    public void caseStart(Start node) {
        apply(node.getPProgramme());
    }

    @Override
    public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node) {
        super.caseADecvarldecfoncProgramme(node);
    }

    @Override
    public void caseALdecfoncProgramme(ALdecfoncProgramme node) {
        super.caseALdecfoncProgramme(node);
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node) {
        super.caseAOptdecvar(node);
    }

    @Override
    public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node) {
        super.caseADecvarldecvarListedecvar(node);
    }

    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node) {
        super.caseADecvarListedecvar(node);
    }

    @Override
    public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node) {
        super.caseADecvarldecvarListedecvarbis(node);
    }

    @Override
    public void caseADecvarListedecvarbis(ADecvarListedecvarbis node) {
        super.caseADecvarListedecvarbis(node);
    }

    @Override
    public void caseADecvarentierDecvar(ADecvarentierDecvar node) {
        super.caseADecvarentierDecvar(node);
    }

    @Override
    public void caseADecvartableauDecvar(ADecvartableauDecvar node) {
        super.caseADecvartableauDecvar(node);
    }

    @Override
    public void caseALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node) {
        SaDec decfonc = (SaDec) apply(node.getDecfonc());
        SaLDec ldecfonc = (SaLDec) apply(node.getListedecfonc());
        returnValue = new SaLDec(decfonc,ldecfonc);
    }

    @Override
    public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node) {
        returnValue = null;
    }

    @Override
    public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node) {
        String indetif = apply(node.getIdentif()).toString();
        SaLDec var= (SaLDec) apply(node.getListeparam());
        SaLDec listepar= (SaLDec) apply(node.getListeparam());
        SaInst bloc = (SaInst) apply(node.getInstrbloc());
        returnValue = new SaDecFonc(indetif,listepar,var,bloc);
    }

    @Override
    public void caseAInstrDecfonc(AInstrDecfonc node) {
        String indetif= apply(node.getIdentif()).toString();
        SaLDec listepar= (SaLDec) apply(node.getListeparam());
        SaInst bloc = (SaInst) apply(node.getInstrbloc());
        returnValue = new SaDecFonc(indetif,listepar,null,bloc);
    }

    @Override
    public void caseASansparamListeparam(ASansparamListeparam node) {
        returnValue= null;
    }

    @Override
    public void caseAAvecparamListeparam(AAvecparamListeparam node) {
        apply(node.getListedecvar());
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node) {
        apply(node.getInstraffect());
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node) {
        apply(node.getInstrbloc());
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node) {
        apply(node.getInstrsi());
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node) {
        apply(node.getInstrtantque());
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node) {
        apply(node.getInstrappel());
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node) {
        apply(node.getInstrretour());
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node) {
        apply(node.getInstrecriture());
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node) {
        apply(node.getInstrvide());
    }

    @Override
    public void caseAInstraffect(AInstraffect node) {
        SaExp var= (SaExp) apply(node.getVar());
        SaExp exp= (SaExp) apply(node.getExp());
        returnValue = new SaExpEqual(var,exp);
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node) {
        apply(node.getListeinst());
    }

    @Override
    public void caseALinstrecListeinst(ALinstrecListeinst node) {
        SaInst inst= (SaInst) apply(node.getInstr());
        SaLInst list= (SaLInst) apply(node.getListeinst());
        returnValue = new SaLInst(inst,list);
    }

    @Override
    public void caseALinstfinalListeinst(ALinstfinalListeinst node) {
        returnValue= null;
    }

    @Override
    public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node) {
        SaExp op= (SaExp) apply(node.getExp());
        SaInst inst= (SaInst) apply(node.getInstrbloc());
        SaInst instrsinon = (SaInst) apply(node.getInstrsinon());
        returnValue= new SaInstSi(op,inst,instrsinon);
    }

    @Override
    public void caseASanssinonInstrsi(ASanssinonInstrsi node) {
        SaExp op= (SaExp) apply(node.getExp());
        SaInst inst= (SaInst) apply(node.getInstrbloc());
        returnValue = new SaInstSi(op,inst,null);
    }

    @Override
    public void caseAInstrsinon(AInstrsinon node) {
        apply(node.getInstrbloc());
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node) {
        SaExp op= (SaExp) apply(node.getExp());
        SaInst op2 = (SaInst) apply(node.getInstrbloc());
        returnValue = new SaInstTantQue(op,op2);
    }

    @Override
    public void caseAInstrappel(AInstrappel node) {
        apply(node.getAppelfct());
    }

    @Override
    public void caseAInstrretour(AInstrretour node) {
        SaExp op= (SaExp) apply(node.getExp());
        returnValue = new SaInstRetour(op);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node) {
        SaExp op3 = (SaExp) apply(node.getExp());
        returnValue = new SaInstEcriture(op3);
    }

    @Override
    public void caseAInstrvide(AInstrvide node) {
        apply(node.getPointVirgule());
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        SaExp op1 = (SaExp) apply(node.getExp());
        SaExp op2 = (SaExp) apply(node.getExp1());
        this.returnValue = new SaExpOr(op1,op2);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node) {
        apply(node.getExp1());
    }

    @Override
    public void caseAEtExp1(AEtExp1 node) {
        SaExp op1 = (SaExp) apply(node.getExp1());
        SaExp op2 = (SaExp) apply(node.getExp2());
        this.returnValue = new SaExpAnd(op1,op2);
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node) {
        apply(node.getExp2());
    }

    @Override
    public void caseAInfExp2(AInfExp2 node) {
        SaExp op1 = (SaExp) apply(node.getExp2());
        SaExp op2 = (SaExp) apply(node.getExp3());
        this.returnValue = new SaExpInf(op1,op2);
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node) {
        SaExp op1 = (SaExp) apply(node.getExp2());
        SaExp op2 = (SaExp) apply(node.getExp3());
        this.returnValue = new SaExpEqual(op1,op2);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        apply(node.getExp3());
    }

    @Override
    public void caseAPlusExp3(APlusExp3 node) {
        SaExp op1 = (SaExp) apply(node.getExp3());
        SaExp op2 = (SaExp) apply(node.getExp4());
        this.returnValue = new SaExpAdd(op1, op2);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node) {
        SaExp op1 = (SaExp) apply(node.getExp3());
        SaExp op2 = (SaExp) apply(node.getExp4());
        this.returnValue = new SaExpSub(op1, op2);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        apply(node.getExp4());
    }

    @Override
    public void caseAFoisExp4(AFoisExp4 node) {
        SaExp op1 = (SaExp) apply(node.getExp4());
        SaExp op2 = (SaExp) apply(node.getExp5());
        this.returnValue = new SaExpMult(op1, op2);
    }

    @Override
    public void caseADiviseExp4(ADiviseExp4 node) {
        SaExp op1 = (SaExp) apply(node.getExp4());
        SaExp op2 = (SaExp) apply(node.getExp5());
        this.returnValue = new SaExpDiv(op1, op2);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        apply(node.getExp5());
    }

    @Override
    public void caseANonExp5(ANonExp5 node) {
        SaExp op1 = (SaExp) apply(node.getExp5());
        this.returnValue = new SaExpNot(op1);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        apply(node.getExp6());
    }

    @Override
    public void caseANombreExp6(ANombreExp6 node) {
        apply(node.getNombre());
    }

    @Override
    public void caseAAppelfctExp6(AAppelfctExp6 node) {
        apply(node.getAppelfct());
    }

    @Override
    public void caseAVarExp6(AVarExp6 node) {
        apply(node.getVar());
    }

    // TODO
    @Override
    public void caseAParenthesesExp6(AParenthesesExp6 node) {
        super.caseAParenthesesExp6(node);
    }

    @Override
    public void caseALireExp6(ALireExp6 node) {
        apply(node.getLire());
    }

    // TODO
    @Override
    public void caseAVartabVar(AVartabVar node) {
        super.caseAVartabVar(node);
    }

    @Override
    public void caseAVarsimpleVar(AVarsimpleVar node) {
        apply(node.getIdentif());
    }

    @Override
    public void caseARecursifListeexp(ARecursifListeexp node) {
        apply(node.getListeexpbis());
    }

    @Override
    public void caseAFinalListeexp(AFinalListeexp node) {
        super.caseAFinalListeexp(node);
    }

    @Override
    public void caseAFinalListeexpbis(AFinalListeexpbis node) {
        super.caseAFinalListeexpbis(node);
    }

    @Override
    public void caseARecursifListeexpbis(ARecursifListeexpbis node) {
        super.caseARecursifListeexpbis(node);
    }

    @Override
    public void caseAAvecparamAppelfct(AAvecparamAppelfct node) {

        super.caseAAvecparamAppelfct(node);
    }

    @Override
    public void caseASansparamAppelfct(ASansparamAppelfct node) {
        new ASansparamAppelfct();
        super.caseASansparamAppelfct(node);
    }


}
