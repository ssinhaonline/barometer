
const handleFormSubmit = event => {
  
    // Stop the form from submitting since we’re handling that with AJAX.
    event.preventDefault();
    
    // TODO: Call our function to get the form data.
    const data = {};
    
    // Demo only: print the form data onscreen as a formatted JSON object.
    const dataContainer = document.getElementById('dataSelection');
    
    // Use `JSON.stringify()` to make the output valid, human-readable JSON.
    dataContainer.textContent = JSON.stringify(data, null, "  ");
    
    // ...this is where we’d actually do something with the form data...
  };

  const handleFormSubmit = event => {/* omitted for brevity */};

/*
 * This is where things actually get started. We find the form element using
 * its class name, then attach the `handleFormSubmit()` function to the 
 * `submit` event.
 */
const form = document.getElementById('contact-form')[0];
form.addEventListener('submit', handleFormSubmit);

var trace1 = {
    type: "scatter",
    mode: "lines",
    name: 'Data',
    x: ['2015-02-07 00:00:00', '2015-02-07 00:01:00', '2015-02-07 00:02:00', '2015-02-07 00:03:00', '2015-02-07 00:04:00','2015-02-07 00:05:00'],
    y: [2, 4, 5, 2, 1, 3],
    line: { color: '#17BECF' }
};

var trace2 = {
    type: "scatter",
    mode: "markers",
    name: 'Outliers',
    x: ['2015-02-07 00:01:00', '2015-02-07 00:05:00'],
    y: [4, 3],
    marker: { 
        color: '#DF0101',
        size: 20,
        opacity: 0.5
 }
};


var data = [trace1, trace2];

var layout = {
    title: 'Outliers in ' + 'statisticCount' + ' at outlier detection threshold = ' + '0.1',
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

Plotly.newPlot('historicalDataPreprocessed', data, layout);