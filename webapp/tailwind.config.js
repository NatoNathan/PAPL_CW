module.exports = {
	purge: ['./src/**/*.{js,jsx,ts,tsx}', './public/index.html'],
	darkMode: false, // or 'media' or 'class'
	theme: {
		extend: {
			gridTemplateRows: {
				// Simple 8 row grid
				'8': 'repeat(8, minmax(0, 1fr))',
				'12': 'repeat(12, minmax(0, 1fr))'
			}
		},
	},
	variants: {
		extend: {

		},
	},
	plugins: [],
}
