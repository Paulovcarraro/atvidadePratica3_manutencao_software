public class RelatorioVendas {

    private List<double[]> registrosDeVendas;
    private boolean aplicarDesconto;
    private String nomeDoRelatorio;

    private static final double TAXA_DESCONTO = 0.1;

    public RelatorioVendas(List<double[]> registrosDeVendas, boolean aplicarDesconto, String nomeDoRelatorio) {
        this.registrosDeVendas = registrosDeVendas;
        this.aplicarDesconto = aplicarDesconto;
        this.nomeDoRelatorio = nomeDoRelatorio;
    }

    public String gerarRelatorio() {
        double total = calcularTotal();
        double totalComDesconto = aplicarDesconto(total);
        String status = determinarStatus(totalComDesconto);

        return montarRelatorio(totalComDesconto, status);
    }

    private double calcularTotal() {
        double total = 0;
        for (double[] registro : registrosDeVendas) {
            total += registro[1];
        }
        return total;
    }

    private double aplicarDesconto(double total) {
        if (aplicarDesconto) {
            return total - (total * TAXA_DESCONTO);
        }
        return total;
    }

    private String determinarStatus(double total) {
        if (total > 10000) {
            return "A";
        } else if (total > 5000) {
            return "B";
        } else {
            return "C";
        }
    }

    private String montarRelatorio(double total, String status) {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("Relatorio: ").append(nomeDoRelatorio).append("\n");
        relatorio.append("Total: ").append(total).append("\n");
        relatorio.append("STATUS: ").append(status);

        return relatorio.toString();
    }
}

