document.addEventListener('DOMContentLoaded', () => {
    const quote = document.querySelector('.quote');
    const buttons = document.querySelectorAll('.btn');

    // Subtle hover effect for quote
    quote.addEventListener('mouseenter', () => {
        quote.style.textDecoration = 'underline';
        quote.style.color = '#588157';
    });

    quote.addEventListener('mouseleave', () => {
        quote.style.textDecoration = 'none';
        quote.style.color = '#DAD7CD';
    });

    // Button hover animations
    buttons.forEach(button => {
        button.addEventListener('mouseenter', () => {
            button.style.transform = 'scale(1.05)';
            button.style.boxShadow = '0 6px 8px rgba(0,0,0,0.2)';
        });

        button.addEventListener('mouseleave', () => {
            button.style.transform = 'scale(1)';
            button.style.boxShadow = '0 4px 6px rgba(0,0,0,0.1)';
        });
    });
});
