# Route Planner

Projet de groupe de Compilation - Groupe CHATEL-GUIZELIN

## Our team

### Team members

- CHATEL Roméo
- GUIZELIN Florian
## Tools

### Generate sc packages

```bash
java -jar sablecc.jar src/grammaireL.sablecc
```

### Generate compare_arbre

```bash
cd test/compare_arbres
make all
```

### Run Evaluate.py

```bash
cd ..
./evaluate.py
```

## Project advancement

- [x] **Analyse syntaxique (TP1)** `> 96.43%`
- [x] **Construction de l'arbre abstrait (TP2)** `> 82.14%`
- [x] **Construction de la table des symboles (TP3 & 4)** `> 96.43%`
- [x] **Production du code trois adresses (TP5 & 6)** `> 82.14%`
- [ ] **Production du pré-code assembleur (TP7)**
- [ ] **Production et résolution du graphe d'analyse (TP 8)**
- [ ] **Allocation de registres (TP9)**

## Other people's code

- La grammaire est celle de référence, car la nôtre a une erreur que l'on n'a pas trouvée et donc pour ne pas être en retard sur les tp suivant nous avons utiliser celle de référence.
- Méthode *apply* de Sc2sa nous a été donnée par Nicolas BOURRAS.
