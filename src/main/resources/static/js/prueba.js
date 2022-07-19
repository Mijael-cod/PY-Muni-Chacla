window.addEventListener('popstate', function(event) {
history.pushState(null, null, window.location.pathname);
history.pushState(null, null, window.location.pathname);
}, false);


