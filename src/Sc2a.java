import sa.SaNode;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2a extends DepthFirstAdapter {
    private SaNode returnvalue;

    @Override
    public void defaultIn(Node node) {
        super.defaultIn(node);
    }

    @Override
    public void defaultOut(Node node) {
        super.defaultOut(node);
    }

    @Override
    public void caseStart(Start node) {
        super.caseStart(node);
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
        super.caseALdecfoncrecListedecfonc(node);
    }

    @Override
    public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node) {
        super.caseALdecfoncfinalListedecfonc(node);
    }

    @Override
    public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node) {
        super.caseADecvarinstrDecfonc(node);
    }

    @Override
    public void caseAInstrDecfonc(AInstrDecfonc node) {
        super.caseAInstrDecfonc(node);
    }

    @Override
    public void caseASansparamListeparam(ASansparamListeparam node) {
        super.caseASansparamListeparam(node);
    }

    @Override
    public void caseAAvecparamListeparam(AAvecparamListeparam node) {
        super.caseAAvecparamListeparam(node);
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node) {
        super.caseAInstraffectInstr(node);
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node) {
        super.caseAInstrblocInstr(node);
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node) {
        super.caseAInstrsiInstr(node);
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node) {
        super.caseAInstrtantqueInstr(node);
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node) {
        super.caseAInstrappelInstr(node);
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node) {
        super.caseAInstrretourInstr(node);
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node) {
        super.caseAInstrecritureInstr(node);
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node) {
        super.caseAInstrvideInstr(node);
    }

    @Override
    public void caseAInstraffect(AInstraffect node) {
        super.caseAInstraffect(node);
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node) {
        super.caseAInstrbloc(node);
    }

    @Override
    public void caseALinstrecListeinst(ALinstrecListeinst node) {
        super.caseALinstrecListeinst(node);
    }

    @Override
    public void caseALinstfinalListeinst(ALinstfinalListeinst node) {
        super.caseALinstfinalListeinst(node);
    }

    @Override
    public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node) {
        super.caseAAvecsinonInstrsi(node);
    }

    @Override
    public void caseASanssinonInstrsi(ASanssinonInstrsi node) {
        super.caseASanssinonInstrsi(node);
    }

    @Override
    public void caseAInstrsinon(AInstrsinon node) {
        super.caseAInstrsinon(node);
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node) {
        super.caseAInstrtantque(node);
    }

    @Override
    public void caseAInstrappel(AInstrappel node) {
        super.caseAInstrappel(node);
    }

    @Override
    public void caseAInstrretour(AInstrretour node) {
        super.caseAInstrretour(node);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node) {
        super.caseAInstrecriture(node);
    }

    @Override
    public void caseAInstrvide(AInstrvide node) {
        super.caseAInstrvide(node);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        super.caseAOuExp(node);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node) {
        super.caseAExp1Exp(node);
    }

    @Override
    public void caseAEtExp1(AEtExp1 node) {
        super.caseAEtExp1(node);
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node) {
        super.caseAExp2Exp1(node);
    }

    @Override
    public void caseAInfExp2(AInfExp2 node) {
        super.caseAInfExp2(node);
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node) {
        super.caseAEgalExp2(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        super.caseAExp3Exp2(node);
    }

    @Override
    public void caseAPlusExp3(APlusExp3 node) {
        super.caseAPlusExp3(node);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node) {
        super.caseAMoinsExp3(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        super.caseAExp4Exp3(node);
    }

    @Override
    public void caseAFoisExp4(AFoisExp4 node) {
        super.caseAFoisExp4(node);
    }

    @Override
    public void caseADiviseExp4(ADiviseExp4 node) {
        super.caseADiviseExp4(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        super.caseAExp5Exp4(node);
    }

    @Override
    public void caseANonExp5(ANonExp5 node) {
        super.caseANonExp5(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        super.caseAExp6Exp5(node);
    }

    @Override
    public void caseANombreExp6(ANombreExp6 node) {
        super.caseANombreExp6(node);
    }

    @Override
    public void caseAAppelfctExp6(AAppelfctExp6 node) {
        super.caseAAppelfctExp6(node);
    }

    @Override
    public void caseAVarExp6(AVarExp6 node) {
        super.caseAVarExp6(node);
    }

    @Override
    public void caseAParenthesesExp6(AParenthesesExp6 node) {
        super.caseAParenthesesExp6(node);
    }

    @Override
    public void caseALireExp6(ALireExp6 node) {
        super.caseALireExp6(node);
    }

    @Override
    public void caseAVartabVar(AVartabVar node) {
        super.caseAVartabVar(node);
    }

    @Override
    public void caseAVarsimpleVar(AVarsimpleVar node) {
        super.caseAVarsimpleVar(node);
    }

    @Override
    public void caseARecursifListeexp(ARecursifListeexp node) {
        super.caseARecursifListeexp(node);
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
        super.caseASansparamAppelfct(node);
    }
}
