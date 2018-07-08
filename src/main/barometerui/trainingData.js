
var trace1 = {
    type: "scatter",
    mode: "lines",
    name: 'Data',
    x: ['2015-02-07 00:00:00', '2015-02-07 00:01:00', '2015-02-07 00:02:00', '2015-02-07 00:03:00', '2015-02-07 00:04:00','2015-02-07 00:05:00'],
    y: [2, 4, 5, 2, 1, 3],
    line: { color: '#17BECF' }
};


var data = [trace1];

var layout = {
    title: 'Training Data',
    xaxis: {
        autorange: true,
        range: ['2015-02-07 00:00:00', '2015-02-07 00:05:00'],
        rangeselector: {
            buttons: [
                {
                    count: 1,
                    label: '1m',
                    step: 'minute',
                    stepmode: 'backward'
                },
                { step: 'all' }
            ]
        },
        rangeslider: { range: ['2015-02-07 00:00:00', '2015-02-07 00:05:00'] },
        type: 'date'
    },
    yaxis: {
        autorange: true,
        type: 'linear'
    }
};

console.log(trace1);

Plotly.newPlot('trainingData', data, layout);