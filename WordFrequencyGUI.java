import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.regex.Pattern;

public class WordFrequencyGUI extends JFrame {
    private static final Pattern NON_WORDS = Pattern.compile("[^\\p{L}\\p{N}']+");
    private final JTextArea input = new JTextArea(10, 40);
    private final JTextArea output = new JTextArea(12, 40);

    public WordFrequencyGUI() {
        super("Word Frequency Counter");
        output.setEditable(false);

        JButton analyze = new JButton("Analyze");
        analyze.addActionListener(e -> analyzeText());

        JPanel top = new JPanel(new BorderLayout(8, 8));
        top.add(new JLabel("Enter text below:"), BorderLayout.NORTH);
        top.add(new JScrollPane(input), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(8, 8));
        bottom.add(analyze, BorderLayout.NORTH);
        bottom.add(new JScrollPane(output), BorderLayout.CENTER);

        setLayout(new BorderLayout(12, 12));
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void analyzeText() {
        String cleaned = NON_WORDS.matcher(input.getText().toLowerCase()).replaceAll(" ").trim();
        Map<String, Integer> counts = new HashMap<>();
        if (!cleaned.isEmpty()) {
            for (String w : cleaned.split("\\s+")) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }
        Map<String, Integer> sorted = new TreeMap<>(counts);

        StringBuilder sb = new StringBuilder();
        sb.append("Word Frequencies (alphabetical):\n");
        sorted.forEach((k, v) -> sb.append(k).append(": ").append(v).append("\n"));
        sb.append("\nSummary:\nUnique words: ").append(sorted.size());
        int total = sorted.values().stream().mapToInt(Integer::intValue).sum();
        sb.append("\nTotal words: ").append(total);

        output.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordFrequencyGUI().setVisible(true));
    }
}
