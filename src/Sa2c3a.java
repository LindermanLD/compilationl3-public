import c3a.*;
import sa.*;
import ts.Ts;
import ts.TsItemVar;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {

    private C3a c3a;
    private Ts table;
    private Ts tableCourante;

    public Sa2c3a(SaNode root, Ts table) {
        this.c3a = new C3a();
        this.table = table;
        root.accept(this);
    }

    public C3a getC3a() {
        return c3a;
    }

    private TsItemVar getVar(String name) {
        if (this.tableCourante.getVar(name) != null) {
            return this.tableCourante.getVar(name);
        } else {
            return this.table.getVar(name);
        }
    }

    @Override
    public C3aOperand visit(SaProg node) {
        node.getFonctions().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaExpInt node) {
        return new C3aConstant(node.getVal());
    }

    @Override
    public C3aOperand visit(SaExpVar node) {
        return node.getVar().accept(this);
    }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        c3a.ajouteInst(new C3aInstWrite(node.getArg().accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) {
        C3aLabel testTantQue = c3a.newAutoLabel();
        C3aLabel suiteTantQue = c3a.newAutoLabel();
        c3a.addLabelToNextInst(testTantQue);
        c3a.ajouteInst(new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, suiteTantQue, ""));
        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(testTantQue, ""));
        c3a.addLabelToNextInst(suiteTantQue);
        return null;
    }

    @Override
    public C3aOperand visit(SaDecFonc node) {
        C3aInstFBegin begin = new C3aInstFBegin(table.getFct(node.getNom()), "begin function");
        c3a.ajouteInst(begin);
        this.tableCourante = this.table.getTableLocale(node.getNom());
        if (node.getCorps() != null)
            node.getCorps().accept(this);
        C3aInstFEnd end = new C3aInstFEnd("");
        c3a.ajouteInst(end);
        return null;
    }

    @Override
    public C3aOperand visit(SaInstAffect node) {
        c3a.ajouteInst(new C3aInstAffect(node.getRhs().accept(this), node.getLhs().accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaVarSimple node) {
        return new C3aVar(this.getVar(node.getNom()), null);
    }

    @Override
    public C3aOperand visit(SaAppel node) {
        if (node.getArguments() != null) {
            node.getArguments().accept(this);
        }
        C3aOperand returnResult = c3a.newTemp();
        C3aInstCall instrCall = new C3aInstCall(new C3aFunction(this.table.getFct(node.getNom())), returnResult, "");
        c3a.ajouteInst(instrCall);
        return returnResult;
    }

    @Override
    public C3aOperand visit(SaExpAppel node) {
        return node.getVal().accept(this);
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp returnResult = c3a.newTemp();
        c3a.ajouteInst(new C3aInstAdd(op1, op2, returnResult, ""));
        return returnResult;
    }

    @Override
    public C3aOperand visit(SaExpSub node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp returnResult = c3a.newTemp();
        c3a.ajouteInst(new C3aInstSub(op1, op2, returnResult, ""));
        return returnResult;
    }

    @Override
    public C3aOperand visit(SaExpMult node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp returnResult = c3a.newTemp();
        c3a.ajouteInst(new C3aInstMult(op1, op2, returnResult, ""));
        return returnResult;
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp returnResult = c3a.newTemp();
        c3a.ajouteInst(new C3aInstDiv(op1, op2, returnResult, ""));
        return returnResult;
    }

    @Override
    public C3aOperand visit(SaExpInf node) {
        C3aTemp varTemp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, varTemp, ""));
        c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, label0, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, varTemp, ""));
        c3a.addLabelToNextInst(label0);
        return varTemp;
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        C3aTemp varTemp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, varTemp, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, op2, label0, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, varTemp, ""));
        c3a.addLabelToNextInst(label0);
        return varTemp;
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {
        C3aTemp varTemp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        C3aLabel label1 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, label1, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op2, c3a.False, label1, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.True, varTemp, ""));
        c3a.ajouteInst(new C3aInstJump(label0, ""));
        c3a.addLabelToNextInst(label1);
        c3a.ajouteInst(new C3aInstAffect(c3a.False, varTemp, ""));
        c3a.addLabelToNextInst(label0);
        return varTemp;
    }

    @Override
    public C3aOperand visit(SaExpOr node) {
        C3aTemp varTemp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        C3aLabel label1 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1, c3a.False, label1, ""));
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op2, c3a.False, label1, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, varTemp, ""));
        c3a.ajouteInst(new C3aInstJump(label0, ""));
        c3a.addLabelToNextInst(label1);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, varTemp, ""));
        c3a.addLabelToNextInst(label0);
        return varTemp;
    }

    @Override
    public C3aOperand visit(SaExpNot node) {
        C3aTemp varTemp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        c3a.ajouteInst(new C3aInstAffect(c3a.True, varTemp, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(node.getOp1().accept(this), c3a.False, label0, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, varTemp, ""));
        c3a.addLabelToNextInst(label0);
        return varTemp;
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        c3a.ajouteInst(new C3aInstRead(node.accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaInstSi node) {
        C3aLabel label0 = c3a.newAutoLabel();
        c3a.ajouteInst(new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, label0, ""));
        if (node.getAlors() != null)
            node.getAlors().accept(this);
        if (node.getSinon() != null) {
            C3aLabel label1 = c3a.newAutoLabel();
            c3a.ajouteInst(new C3aInstJump(label1, ""));
            c3a.addLabelToNextInst(label0);
            node.getSinon().accept(this);
            c3a.addLabelToNextInst(label1);
        } else {
            c3a.addLabelToNextInst(label0);
        }
        return null;
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {
        c3a.ajouteInst(new C3aInstReturn(node.getVal().accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        c3a.ajouteInst(new C3aInstParam(node.getTete().accept(this), ""));
        if (node.getQueue() != null)
            node.getQueue().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        TsItemVar tsItemVar = this.getVar(node.getNom());
        return new C3aVar(tsItemVar, node.getIndice().accept(this));
    }
}