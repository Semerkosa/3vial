function loadCharts(chartData_1,chartData_2) {
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart_1);
    google.charts.setOnLoadCallback(drawChart_2);

    function drawChart_1() {
        let data = new google.visualization.DataTable();
        data.addColumn('string', 'Question');
        data.addColumn('number', 'Answers');
        data.addRows(chartData_1);
        let options = {
            'title': 'What do you hope Trivial will help you with?',
            'width': 600,
            'height': 400,
            is3D: true
        };
        let chart = new google.visualization.PieChart(document.getElementById('chart_div_1'));
        chart.draw(data, options);
    }

    function drawChart_2() {
        let data = new google.visualization.DataTable();
        data.addColumn('string', 'Question');
        data.addColumn('number', 'Answers');
        data.addRows(chartData_2);
        let options = {
            'title': 'What do you use to solve this problem now?',
            'width': 600,
            'height': 400,
            is3D: true
        };
        let chart = new google.visualization.PieChart(document.getElementById('chart_div_2'));
        chart.draw(data, options);
    }
}