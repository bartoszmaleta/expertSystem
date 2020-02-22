import repository.FactRepository;
import parser.FactParser;
import parser.RuleParser;
import repository.RuleRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ESPProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    private Map<String, Boolean> userAnswears;

    public ESPProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
        this.userAnswears = new TreeMap<>();
    }
}
