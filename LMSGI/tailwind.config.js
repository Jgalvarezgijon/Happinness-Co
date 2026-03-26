/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./*.html", "./components/**/*.html"],
  theme: {
    extend: {
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
        ampColor: {
          '0%':   { color: '#009bdb' },
          '25%':  { color: '#ba007c' },
          '50%':  { color: '#555555' },
          '75%':  { color: '#ff7b00' },
          '100%': { color: '#009bdb' },
        }
      },
      animation: {
        'animacionLogo': 'ampColor 8s ease-in-out infinite',
      }
    },
  },
  plugins: [],
}
