define(function(cars){
    return {
        type:'line',
        height: 400,
        rows: [           
            {
                view: 'button',
                label: 'Cars',
                click: function() {
                    routie('cars')
                }
            },
            { template:'Row 1'},
            { template:'Row 2'}
        ]
    }
})

