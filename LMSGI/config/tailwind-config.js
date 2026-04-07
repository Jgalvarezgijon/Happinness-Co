tailwind.config = {
    theme: {
        extend: {
            /*Colores guardados para su uso a lo largo del proyecto*/
            colors: {
                corporativo: '#ba007c',
                musica: '#ba007c',
                cine: '#009bdb',
                teatro: '#009bdb',
                exposiciones: '#ff7b00',
                otros: '#555555',
            },
            fontFamily: {
                asenine: ['Asenine', 'sans-serif'],
                archistry: ['"Ar Chistry"', 'sans-serif'],
            },
            keyframes: {
                /*Efecto visual para el símbolo & del logotipo.
                El caracter alterna su opacidad entre los 4 colores corporativos propuestos
                Cada 8 segundos, el símbolo & hace una rotación de color completa*/
                ampColor: {
                    '0%': { color: '#009bdb' },
                    '25%': { color: '#ba007c' },
                    '50%': { color: '#555555' },
                    '75%': { color: '#ff7b00' },
                    '100%': { color: '#009bdb' },
                }
            },
            /*Definición de la animación para su uso en el proyecto*/
            animation: {
                'animacionLogo': 'ampColor 8s ease-in-out infinite',
            }
        }
    }
}