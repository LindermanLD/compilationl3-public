import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {

    private SaNode returnValue;

    public SaNode getRoot() {
        return returnValue;
    }

    private <T extends SaNode> T apply(Switchable sc) {
        sc.apply(this);
        //noinspection unchecked
        return (T) returnValue;
    }

    @Override
    public void caseStart(Start node) {
        apply(node.getPProgramme());
    }

    @Override
    public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node) {
        returnValue = new SaProg(apply(node.getOptdecvar()), apply(node.getListedecfonc()));
    }

    @Override
    public void caseALdecfoncProgramme(ALdecfoncProgramme node) {
        returnValue = new SaProg(null, apply(node.getListedecfonc()));
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node) {
        apply(node.getListedecvar());
    }

    @Override
    public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node) {
        returnValue = new SaLDec(apply(node.getDecvar()), apply(node.getListedecvarbis()));
    }

    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node) {
        returnValue = new SaLDec(apply(node.getDecvar()), null);
    }

    @Override
    public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node) {
        returnValue = new SaLDec(apply(node.getDecvar()), apply(node.getListedecvarbis()));
    }

    @Override
    public void caseADecvarListedecvarbis(ADecvarListedecvarbis node) {
        returnValue = new SaLDec(apply(node.getDecvar()), null);
    }

    @Override
    public void caseADecvarentierDecvar(ADecvarentierDecvar node) {
        String identif = node.getIdentif().getText();
        returnValue = new SaDecVar(identif);
    }

    @Override
    public void caseADecvartableauDecvar(ADecvartableauDecvar node) {
        String identif = node.getIdentif().getText();
        int capacity = Integer.parseInt(node.getNombre().getText());
        returnValue = new SaDecTab(identif, capacity);
    }

    @Override
    public void caseALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node) {
        returnValue = new SaLDec(apply(node.getDecfonc()), apply(node.getListedecfonc()));
    }

    @Override
    public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node) {
        returnValue = null;
    }

    @Override
    public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node) {
        String identif = node.getIdentif().getText();
        SaLDec var = apply(node.getListeparam());
        SaLDec listepar = apply(node.getListeparam());
        SaInst bloc = apply(node.getInstrbloc());
        returnValue = new SaDecFonc(identif, listepar, var, bloc);
    }

    @Override
    public void caseAInstrDecfonc(AInstrDecfonc node) {
        String identif = node.getIdentif().getText();
        SaLDec listepar = apply(node.getListeparam());
        SaInst bloc = apply(node.getInstrbloc());
        returnValue = new SaDecFonc(identif, listepar, null, bloc);
    }

    @Override
    public void caseASansparamListeparam(ASansparamListeparam node) {
        returnValue = null;
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
        returnValue = null;
    }

    @Override
    public void caseAInstraffect(AInstraffect node) {
        returnValue = new SaInstAffect(apply(node.getVar()), apply(node.getExp()));
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node) {
        returnValue = new SaInstBloc(apply(node.getListeinst()));
    }

    @Override
    public void caseALinstrecListeinst(ALinstrecListeinst node) {
        returnValue = new SaLInst(apply(node.getInstr()), apply(node.getListeinst()));
    }

    @Override
    public void caseALinstfinalListeinst(ALinstfinalListeinst node) {
        returnValue = null;
    }

    @Override
    public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node) {
        SaExp op = apply(node.getExp());
        SaInst inst = apply(node.getInstrbloc());
        SaInst instrsinon = apply(node.getInstrsinon());
        returnValue = new SaInstSi(op, inst, instrsinon);
    }

    @Override
    public void caseASanssinonInstrsi(ASanssinonInstrsi node) {
        SaExp op = apply(node.getExp());
        SaInst inst = apply(node.getInstrbloc());
        returnValue = new SaInstSi(op, inst, null);
    }

    @Override
    public void caseAInstrsinon(AInstrsinon node) {
        apply(node.getInstrbloc());
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node) {
        SaExp op = apply(node.getExp());
        SaInst op2 = apply(node.getInstrbloc());
        returnValue = new SaInstTantQue(op, op2);
    }

    @Override
    public void caseAInstrappel(AInstrappel node) {
        apply(node.getAppelfct());
    }

    @Override
    public void caseAInstrretour(AInstrretour node) {
        SaExp op = apply(node.getExp());
        returnValue = new SaInstRetour(op);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node) {
        SaExp op3 = apply(node.getExp());
        returnValue = new SaInstEcriture(op3);
    }

    @Override
    public void caseAInstrvide(AInstrvide node) {
        returnValue = null;
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        returnValue = new SaExpOr(apply(node.getExp()), apply(node.getExp1()));
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node) {
        apply(node.getExp1());
    }

    @Override
    public void caseAEtExp1(AEtExp1 node) {
        returnValue = new SaExpAnd(apply(node.getExp1()), apply(node.getExp2()));
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node) {
        apply(node.getExp2());
    }

    @Override
    public void caseAInfExp2(AInfExp2 node) {
        returnValue = new SaExpInf(apply(node.getExp2()), apply(node.getExp3()));
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node) {
        returnValue = new SaExpEqual(apply(node.getExp2()), apply(node.getExp3()));
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        apply(node.getExp3());
    }

    @Override
    public void caseAPlusExp3(APlusExp3 node) {
        SaExp op1 = apply(node.getExp3());
        SaExp op2 = apply(node.getExp4());
        returnValue = new SaExpAdd(op1, op2);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node) {
        SaExp op1 = apply(node.getExp3());
        SaExp op2 = apply(node.getExp4());
        returnValue = new SaExpSub(op1, op2);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        apply(node.getExp4());
    }

    @Override
    public void caseAFoisExp4(AFoisExp4 node) {
        SaExp op1 = apply(node.getExp4());
        SaExp op2 = apply(node.getExp5());
        returnValue = new SaExpMult(op1, op2);
    }

    @Override
    public void caseADiviseExp4(ADiviseExp4 node) {
        SaExp op1 = apply(node.getExp4());
        SaExp op2 = apply(node.getExp5());
        returnValue = new SaExpDiv(op1, op2);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        apply(node.getExp5());
    }

    @Override
    public void caseANonExp5(ANonExp5 node) {
        returnValue = new SaExpNot(apply(node.getNon()));
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        apply(node.getExp6());
    }

    @Override
    public void caseANombreExp6(ANombreExp6 node) {
        int value = Integer.parseInt(node.getNombre().getText());
        returnValue = new SaExpInt(value);
    }

    @Override
    public void caseAAppelfctExp6(AAppelfctExp6 node) {
        returnValue = new SaExpAppel(apply(node.getAppelfct()));
    }

    @Override
    public void caseAVarExp6(AVarExp6 node) {
        returnValue = new SaExpVar(apply(node.getVar()));
    }

    @Override
    public void caseAParenthesesExp6(AParenthesesExp6 node) {
        apply(node.getExp());
    }

    @Override
    public void caseALireExp6(ALireExp6 node) {
        returnValue = new SaExpLire();
    }

    @Override
    public void caseAVartabVar(AVartabVar node) {
        String identif = node.getIdentif().getText();
        returnValue = new SaVarIndicee(identif, apply(node.getExp()));
    }

    @Override
    public void caseAVarsimpleVar(AVarsimpleVar node) {
        String identif = node.getIdentif().getText();
        returnValue = new SaVarSimple(identif);
    }

    @Override
    public void caseARecursifListeexp(ARecursifListeexp node) {
        returnValue = new SaLExp(apply(node.getExp()), apply(node.getListeexpbis()));
    }

    @Override
    public void caseAFinalListeexp(AFinalListeexp node) {
        this.returnValue = new SaLExp(apply(node.getExp()), null);
    }

    @Override
    public void caseARecursifListeexpbis(ARecursifListeexpbis node) {
        returnValue = new SaLExp(apply(node.getExp()), apply(node.getListeexpbis()));
    }

    @Override
    public void caseAFinalListeexpbis(AFinalListeexpbis node) {
        returnValue = new SaLExp(apply(node.getExp()), null);
    }

    @Override
    public void caseAAvecparamAppelfct(AAvecparamAppelfct node) {
        String identif = node.getIdentif().getText();
        this.returnValue = new SaAppel(identif, apply(node.getListeexp()));
    }

    @Override
    public void caseASansparamAppelfct(ASansparamAppelfct node) {
        String identif = node.getIdentif().getText();
        this.returnValue = new SaAppel(identif, null);
    }
}
